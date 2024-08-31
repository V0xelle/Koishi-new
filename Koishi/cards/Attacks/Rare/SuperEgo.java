/*    */ package Koishi.cards.Attacks.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class SuperEgo
/*    */   extends AbstractDefaultCard
/*    */ {
/* 25 */   public static final String ID = KoishiMod.makeID(SuperEgo.class.getSimpleName());
/* 26 */   public static final String IMG = KoishiMod.makeCardPath("SuperEgo.png");
/*    */   
/* 28 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 29 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 30 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 31 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int DAMAGE = 8;
/*    */   
/*    */   private static final int EFFECT = 1;
/*    */   
/*    */   public SuperEgo() {
/* 40 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 41 */     this.baseDamage = 8;
/* 42 */     this.magicNumber = this.baseMagicNumber = 1;
/* 43 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 48 */     KoishiMod.runAnimation("dashAttackB");
/* 49 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
/*    */     
/* 51 */     ArrayList<AbstractIdCard> cardsToRemove = new ArrayList<>();
/* 52 */     int exhaustCounter = 0;
/* 53 */     for (AbstractCard card : p.hand.group) {
/* 54 */       if (card instanceof AbstractIdCard) {
/* 55 */         cardsToRemove.add((AbstractIdCard)card);
/*    */       }
/*    */     } 
/* 58 */     for (AbstractIdCard card : cardsToRemove) {
/* 59 */       p.hand.moveToExhaustPile((AbstractCard)card);
/* 60 */       exhaustCounter++;
/*    */     } 
/* 62 */     cardsToRemove.clear();
/*    */     
/* 64 */     for (AbstractCard card : p.drawPile.group) {
/* 65 */       if (card instanceof AbstractIdCard) {
/* 66 */         cardsToRemove.add((AbstractIdCard)card);
/*    */       }
/*    */     } 
/* 69 */     for (AbstractIdCard card : cardsToRemove) {
/* 70 */       p.drawPile.moveToExhaustPile((AbstractCard)card);
/* 71 */       exhaustCounter++;
/*    */     } 
/* 73 */     cardsToRemove.clear();
/*    */     
/* 75 */     for (AbstractCard card : p.discardPile.group) {
/* 76 */       if (card instanceof AbstractIdCard) {
/* 77 */         cardsToRemove.add((AbstractIdCard)card);
/*    */       }
/*    */     } 
/* 80 */     for (AbstractIdCard card : cardsToRemove) {
/* 81 */       p.discardPile.moveToExhaustPile((AbstractCard)card);
/* 82 */       exhaustCounter++;
/*    */     } 
/* 84 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainEnergyAction(this.magicNumber * exhaustCounter));
/* 85 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber * exhaustCounter));
/* 86 */     cardsToRemove.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 91 */     if (!this.upgraded) {
/* 92 */       upgradeName();
/* 93 */       AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/* 94 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 95 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Rare/SuperEgo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
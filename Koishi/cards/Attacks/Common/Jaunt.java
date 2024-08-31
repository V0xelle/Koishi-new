/*    */ package Koishi.cards.Attacks.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.ForceIntentAction;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Jaunt
/*    */   extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(Jaunt.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("Jaunt.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 7;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 4;
/*    */   private static final int DRAW = 1;
/*    */   
/*    */   public Jaunt() {
/* 35 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 36 */     this.baseDamage = 7;
/* 37 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 42 */     KoishiMod.runAnimation("airAttack");
/* 43 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
/* 44 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
/* 45 */     if (ForceIntentAction.attackTest.test(m)) {
/* 46 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       upgradeDamage(4);
/* 55 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Common/Jaunt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
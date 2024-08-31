/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.cards.Attacks.Common.SubconsciousSweep;
/*    */ import Koishi.cards.Attacks.Uncommon.HeartAttack;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class ReleaseOfTheId
/*    */   extends AbstractDefaultCard
/*    */ {
/* 23 */   public static final String ID = KoishiMod.makeID(ReleaseOfTheId.class.getSimpleName());
/* 24 */   public static final String IMG = KoishiMod.makeCardPath("ReleaseOfTheId.png");
/*    */   
/* 26 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 27 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 28 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 29 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int EFFECT = 3;
/*    */   
/*    */   public ReleaseOfTheId() {
/* 36 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 37 */     this.magicNumber = this.baseMagicNumber = 3;
/* 38 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 43 */     KoishiMod.runAnimation("spellCall");
/* 44 */     ArrayList<AbstractIdCard> cards = new ArrayList<>();
/* 45 */     for (int i = 0; i < this.magicNumber; i++) {
/* 46 */       AbstractIdCard card = AbstractIdCard.returnTrulyRandomIdCard();
/* 47 */       if (this.upgraded) {
/* 48 */         card.upgrade();
/*    */       }
/* 50 */       cards.add(card);
/*    */     } 
/* 52 */     if (!hasDamageIdCard(cards)) {
/*    */       
/* 54 */       ArrayList<AbstractIdCard> damageIdCards = new ArrayList<>();
/* 55 */       damageIdCards.add(new SubconsciousSweep());
/* 56 */       damageIdCards.add(new MassHysteria());
/* 57 */       damageIdCards.add(new HeartAttack());
/* 58 */       Collections.shuffle(damageIdCards, (Random)AbstractDungeon.cardRandomRng.random);
/* 59 */       cards.set(0, damageIdCards.get(0));
/*    */     } 
/* 61 */     for (AbstractCard card : cards) {
/* 62 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new MakeTempCardInDrawPileAction(card, 1, true, true));
/*    */     }
/*    */   }
/*    */   
/*    */   private boolean hasDamageIdCard(ArrayList<AbstractIdCard> cards) {
/* 67 */     for (AbstractIdCard card : cards) {
/* 68 */       if (card instanceof SubconsciousSweep || card instanceof MassHysteria || card instanceof HeartAttack)
/*    */       {
/*    */         
/* 71 */         return true;
/*    */       }
/*    */     } 
/* 74 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 79 */     if (!this.upgraded) {
/* 80 */       upgradeName();
/* 81 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 82 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/ReleaseOfTheId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
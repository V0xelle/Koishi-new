/*    */ package Koishi.cards.Attacks.Common;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.animations.VFXAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.SFXAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.VulnerablePower;
/*    */ import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
/*    */ import com.megacrit.cardcrawl.vfx.combat.ShockWaveEffect;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class BloodcurdlingScream extends AbstractDefaultCard {
/* 25 */   public static final String ID = KoishiMod.makeID(BloodcurdlingScream.class.getSimpleName());
/* 26 */   public static final String IMG = KoishiMod.makeCardPath("BloodcurdlingScream.png");
/*    */   
/* 28 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 29 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL_ENEMY;
/* 30 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 31 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 13;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   private static final int DEBUFF = 2;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 1;
/*    */   
/*    */   public BloodcurdlingScream() {
/* 42 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 43 */     this.baseDamage = 13;
/* 44 */     this.magicNumber = this.baseMagicNumber = 2;
/* 45 */     this.isMultiDamage = true;
/* 46 */     KoishiMod.setBackground((CustomCard)this, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 51 */     KoishiMod.runAnimation("magicAttackForward");
/* 52 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new SFXAction("ATTACK_PIERCING_WAIL"));
/* 53 */     if (Settings.FAST_MODE) {
/* 54 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GREEN_TEXT_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 0.3F));
/*    */     } else {
/* 56 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GREEN_TEXT_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 1.5F));
/*    */     } 
/* 58 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
/* 59 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 60 */     while (iterator.hasNext()) {
/* 61 */       AbstractMonster mo = iterator.next();
/* 62 */       if (mo.hasPower(TerrorPower.POWER_ID)) {
/* 63 */         AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 71 */     return 16.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 77 */     if (!this.upgraded) {
/* 78 */       upgradeName();
/* 79 */       upgradeDamage(3);
/* 80 */       upgradeMagicNumber(1);
/* 81 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Common/BloodcurdlingScream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */